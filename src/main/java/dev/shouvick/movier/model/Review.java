package dev.shouvick.movier.model;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "review")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
	@Id
	private ObjectId id;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;

}
