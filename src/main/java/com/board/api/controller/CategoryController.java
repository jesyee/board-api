package com.board.api.controller;

import com.board.api.controller.dto.CategoryResponseDto;
import com.board.api.controller.dto.CategorySaveRequestDto;
import com.board.api.controller.dto.CategoryUpdateRequestDto;
import com.board.api.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    /**
     * 게시판 카테고리 조회 - 단건 *
     * @param categoryId
     * @return
     * @throws Exception
     */
    @GetMapping("/category/{categoryId}")
    public CategoryResponseDto findCategory(@PathVariable("categoryId") String categoryId) throws Exception {
        return categoryService.findCategory(categoryId);
    }

    /**
     * 게시판 카테고리 조회 - 리스트 *
     * @return
     * @throws Exception
     */
    @GetMapping("/category/list")
    public List<CategoryResponseDto> findCategoryList() throws Exception {
        return categoryService.findCategoryList();
    }

    /**
     * 게시판 카테고리 등록 *
     * @param saveRequestDto
     */
    @PostMapping("/category")
    public void saveCategory(@RequestBody CategorySaveRequestDto saveRequestDto) {
        categoryService.saveCategory(saveRequestDto);
    }

    /**
     * 게시판 카테고리 수정 *
     * @param updateRequestDto
     */
    @PutMapping("/category")
    public void updateCategory(@RequestBody CategoryUpdateRequestDto updateRequestDto) {
        categoryService.updateCategory(updateRequestDto);

    }

    /**
     * 게시판 카테고리 삭제 *
     * @param categoryId
     */
    @DeleteMapping("/category/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") String categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
