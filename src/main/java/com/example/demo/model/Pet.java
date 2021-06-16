package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
   private int id;
   private Category category;
   private String name;
   private List<Tag> tags;
   private PetStatus status;
}
