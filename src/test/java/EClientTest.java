import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.Application;
import com.my.domain.PoemDo;
import com.my.domain.PoemQueryDo;
import com.my.service.PoemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class )
public class EClientTest {

    @Autowired
    private PoemService poemService;

    static TransportClient client = null;

    @PostConstruct
    void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    static {

//        try {
//            client = new PreBuiltTransportClient(Settings.EMPTY)
//                    .addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.40.128"), 9300));
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }

    }

    @PreDestroy
    public void destory() {
        client.close();
    }

    @Test
    public void createIndex() throws JsonProcessingException {
        String indexName = "study";
        String typeName = "poem";
        List<PoemDo> poemDoList = poemService.listPoems(new PoemQueryDo());
        ObjectMapper mapper = new ObjectMapper();
        for (PoemDo poem : poemDoList) {
            IndexResponse resp = client.prepareIndex(indexName, typeName,String.valueOf(poem.getId()))
                    .setSource(mapper.writeValueAsString(poem), XContentType.JSON).get();
            if (null != resp) {
                log.info("创建索引成功,index:{},type:{},id:{}" + resp.getIndex(), resp.getType(), resp.getId());
            }
        }

    }

    @Test
    public void get() {
        String indexName = "study";
        String typeName = "poem";
//        GetResponse response = client.prepareGet(indexName,typeName,"id").get();
        GetResponse response = client.prepareGet("index","doc","2").get();
        if (null != response&&response.isExists()) {
            log.info("get:{}",response.getSourceAsString());
        }
    }

    @Test
    public void multiGet() {
        MultiGetResponse multiGetItemResponses = client.prepareMultiGet()
                .add("index", "doc", "1")
                .add("index", "doc", "2", "3")
                .add("study", "poem", "id")
                .get();

        for (MultiGetItemResponse itemResponse : multiGetItemResponses) {
            GetResponse response = itemResponse.getResponse();
            if (response.isExists()) {
                log.info("get:{}",response.getSourceAsString());
            }
        }
    }

    @Test
    public void multySearch() {
        SearchRequestBuilder b1 = client.prepareSearch().setQuery(QueryBuilders.queryStringQuery("月"));
        SearchRequestBuilder b2 = client.prepareSearch().setQuery(QueryBuilders.matchQuery("content","水"));

        MultiSearchResponse response = client.prepareMultiSearch().add(b1).add(b2).get();

        long mhits = 0;

        for (MultiSearchResponse.Item item : response.getResponses()) {
            SearchResponse res = item.getResponse();
            SearchHit[] searchHit = res.getHits().getHits();
            if (null != searchHit) {
                log.info("遍历查找到的文档：\n");
                for(SearchHit hit : searchHit)
                log.info(hit.getSourceAsString()+"\n");
            }
            mhits+=res.getHits().getTotalHits();
        }
        log.info("共查找到{}条匹配记录!",mhits);
    }


    /**
     * 暂不可用
     */
    @Test
    public void nesteSearch() {
        client.prepareSearch().setQuery(QueryBuilders.nestedQuery("", QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("content", "水")), ScoreMode.Avg));

    }
}
