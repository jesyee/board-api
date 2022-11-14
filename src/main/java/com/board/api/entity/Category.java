package com.board.api.entity;

import com.board.api.controller.dto.CategoryUpdateRequestDto;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(schema = "board", name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Size(max = 10)
    private String code;

    @Size(max = 50)
    private String name;

    @Type(type = "yes_no")
    private Boolean useYn;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    public void updateData(CategoryUpdateRequestDto updateRequestDto) {
        this.code = updateRequestDto.getCode();
        this.name = updateRequestDto.getName();
        this.useYn = updateRequestDto.getUseYn();
    }

    public void deleteData() {
        this.useYn = false;
    }
}
