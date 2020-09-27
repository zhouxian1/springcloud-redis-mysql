package com.zhouxian.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "zhouxian",type = "goods",shards = 3,replicas = 3)
public class Goods {
    @Field(type = FieldType.Long)
    @Id
    Long id;
    @Field(type = FieldType.Text)
    String title;
    @Field(type = FieldType.Keyword,index = false)
    String images;
    @Field(type = FieldType.Double)
    double price;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Goods(Long id, String title, String images, double price) {
        this.id = id;
        this.title = title;
        this.images = images;
        this.price = price;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", images='" + images + '\'' +
                ", price=" + price +
                '}';
    }
}
