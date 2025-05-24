package asil.uz.darsKun_uz.firstsection.controller;


import asil.uz.darsKun_uz.firstsection.Dto.LangResponseDTO;
import asil.uz.darsKun_uz.firstsection.Dto.SectionDto;
import asil.uz.darsKun_uz.firstsection.Enumrol.Lenguagc;
import asil.uz.darsKun_uz.firstsection.service.SectionService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/sectionL")
public class SectionController {


    @Autowired
    private SectionService service;

    @PostMapping("")
    public ResponseEntity<SectionDto> create(@Valid @RequestBody SectionDto dto) {

        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectionDto> update(@PathVariable("id") Integer id, @RequestBody SectionDto newDto) {
        return ResponseEntity.ok(service.update(id, newDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<List<SectionDto>> getAll() {
        return ResponseEntity.ok(service.getAllByOrder());
    }

    // /api/v1/category/lang?language=uz
    @GetMapping("/lang")
    public ResponseEntity<List<LangResponseDTO>> getByLang(@RequestHeader(name = "Accept-Language", defaultValue = "UZ") Lenguagc language) {
        return ResponseEntity.ok(service.getAllbyLang(language));
    }

}
