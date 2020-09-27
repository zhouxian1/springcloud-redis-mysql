import com.zhouxian.es.EsApplication;
import com.zhouxian.es.entity.Goods;
import com.zhouxian.es.repository.GoodsRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.range.AbstractRangeBuilder;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.fetch.FetchSearchResult;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApplication.class)
public class myTest {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    GoodsRepository goodsRepository;

    @Test
    public  void create(){
//        elasticsearchTemplate.createIndex(Goods.class);
//        elasticsearchTemplate.putMapping(Goods.class);
//        Goods goods = new Goods();
//        goods.setId(Long.valueOf(1111));
//        goods.setImages("aa.jpg");
//        goods.setPrice(1111);
//        goods.setTitle("小米手机");
//        goodsRepository.save(goods);
        List<Goods> goods = new ArrayList<>();
        goods.add(new Goods(1L,"大米手机","qq.jpg",1121));
        goods.add(new Goods(2L,"大米手机a","qq.jpg",2121));
        goods.add(new Goods(3L,"大米手机b","qq.jpg",3121));
        goods.add(new Goods(4L,"大米手机c","qq.jpg",4121));
        goods.add(new Goods(5L,"大米手机d","qq.jpg",3121));
        goods.add(new Goods(6L,"大米手机e","qq.jpg",2121));
        goods.add(new Goods(7L,"大米手机f","qq.jpg",1121));
        goodsRepository.saveAll(goods);

    }

    @Test
    public  void create1(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{"id","title"},null));
        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("title","大米手机"));
        nativeSearchQueryBuilder.withPageable(PageRequest.of(0,5));
        Page<Goods> search = goodsRepository.search(nativeSearchQueryBuilder.build());
//        search.forEach(goods -> System.out.println(goods));
        List<Goods> content = search.getContent();

        for(Goods g:content){
            System.out.println(g);
        }
    }
    @Test
    public  void  agg(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.addAggregation(AggregationBuilders.terms("aaa").field("images"));
        AggregatedPage<Goods> goods = elasticsearchTemplate.queryForPage(queryBuilder.build(), Goods.class);
        Aggregations aggregations = goods.getAggregations();
        StringTerms terms= aggregations.get("aaa");
        List<StringTerms.Bucket> buckets = terms.getBuckets();
        buckets.forEach(bucket -> {
            System.out.println(bucket.getKey());
            System.out.println(bucket.getDocCount());
        });



    }
}
