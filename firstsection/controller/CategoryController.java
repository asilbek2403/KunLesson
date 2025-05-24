package asil.uz.darsKun_uz.firstsection.controller;

import asil.uz.darsKun_uz.firstsection.Dto.CategoryDto;
import asil.uz.darsKun_uz.firstsection.Enumrol.Lenguagc;
import asil.uz.darsKun_uz.firstsection.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("")
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable("id") Integer id, @RequestBody CategoryDto newDto) {
        return ResponseEntity.ok(service.update(id, newDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok(service.getAllByOrder());
    }

    // /api/v1/category/lang?language=uz
    @GetMapping("/lang")
    public ResponseEntity<List<CategoryDto>> getByLang(@RequestHeader(name = "Accept-Language", defaultValue = "uz") Lenguagc language) {
        return ResponseEntity.ok(service.getAllByLang(language));
    }
}

