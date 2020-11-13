package common.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: springcloud-library
 * @description:
 * @author: Reagan Li
 * @create: 2020-11-12 22:20
 **/
@Data
public class Book {

    private Long bookId;

    private String title;

    private String bookType;

    private String description;

    private String author;

    private Integer wordCount;

    private String status;

    private Date publishTime;

    private Date createTime;

}
