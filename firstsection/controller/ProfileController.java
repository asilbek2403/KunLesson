package asil.uz.darsKun_uz.firstsection.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("")
    public ResponseEntity<ProfileDTO> create(@RequestBody ProfileDTO dto) {
        return ResponseEntity.ok(profileService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileDTO> update(@PathVariable Integer id, @RequestBody ProfileDTO dto) {
        return ResponseEntity.ok(profileService.update(id, dto));
    }

    @PutMapping("/own")
    public ResponseEntity<ProfileDTO> updateOwn(@RequestBody ProfileDTO dto, @RequestHeader("Profile-Id") Integer id) {
        return ResponseEntity.ok(profileService.updateOwnDetails(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(profileService.delete(id));
    }

    @GetMapping("/list")
    public ResponseEntity<Page<ProfileDTO>> list(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(profileService.list(page, size));
    }

    @PutMapping("/photo")
    public ResponseEntity<?> updatePhoto(@RequestParam Integer id, @RequestParam String photoId) {
        profileService.updatePhoto(id, photoId);
        return ResponseEntity.ok("Updated");
    }

    @PostMapping("/filter")
    public ResponseEntity<List<ProfileDTO>> filter(@RequestBody ProfileFilterDTO filter) {
        return ResponseEntity.ok(profileService.filter(filter));
    }
}

