package com.fuxin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: Tag
 * Author: Fuu
 * Date: 2023/7/25
 */
@Entity
@Table(name = "t_tag")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();
}
