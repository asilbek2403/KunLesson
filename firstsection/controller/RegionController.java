package asil.uz.darsKun_uz.firstsection.controller;


import asil.uz.darsKun_uz.firstsection.Dto.RegionDto;
import asil.uz.darsKun_uz.firstsection.Dto.RegionShortDto;
import asil.uz.darsKun_uz.firstsection.Enumrol.Lenguagc;
import asil.uz.darsKun_uz.firstsection.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("mm")
    public ResponseEntity<String> qad(){
        return ResponseEntity.ok("Muvaffaqqiyat");
    }

    // 1. Create (ADMIN)
    @PostMapping("/create")
    public ResponseEntity<RegionDto> create(@RequestBody RegionDto dto) {
        RegionDto regionDto = regionService.create(dto);
        return new ResponseEntity<>(regionDto, HttpStatus.CREATED);
    }

    // 2. Update (ADMIN)
    @PutMapping("/id/{id}")
    public ResponseEntity<RegionDto> update(@PathVariable Integer id, @RequestBody RegionDto dto) {
        RegionDto regionDto  =regionService.update(id, dto);
        return ResponseEntity.ok(regionDto);
    }

    // 3. Delete (ADMIN)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        regionService.delete(id);
        return ResponseEntity.ok().build();
    }

    // 4. Get List (ADMIN)
    @GetMapping("/list")
    public ResponseEntity<List<RegionDto>> getAll() {
        List<RegionDto> regionDto  =regionService.getAll();
        return ResponseEntity.ok(regionDto);
    }

    // 5. Get By Lang
    @GetMapping("/lang/{lang}")
    public ResponseEntity<List<RegionShortDto>> getByLangA(@PathVariable Lenguagc lang) {
        List<RegionShortDto> list = regionService.getByLeng(lang);
        return ResponseEntity.ok(list);
    }
}
