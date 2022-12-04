package com.tmt.controller;

import java.util.Collection;
import java.util.UUID;

import com.tmt.domain.request.CreateAgency;
import com.tmt.domain.entity.Agency;
import com.tmt.service.criteria.AgencySearchRequest;
import com.tmt.domain.response.LightAgency;
import com.tmt.service.AgencyService;
import com.tmt.validator.CreateGroup;
import com.tmt.validator.EditGroup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agencies")
@Slf4j
@RequiredArgsConstructor
public class AgencyController {

    final AgencyService service;


    @PostMapping
    public ResponseEntity<LightAgency> add(@Validated(CreateGroup.class) @RequestBody final CreateAgency dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<Page<Agency>> getAll(AgencySearchRequest params) {
        return ResponseEntity.ok(service.search(params));
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<LightAgency>> getList(@RequestBody final Collection<UUID> ids) {
        return ResponseEntity.ok(service.findByIds(ids));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LightAgency> getOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.find(UUID.fromString(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LightAgency> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.find(UUID.fromString(id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LightAgency> edit(
            @Validated(EditGroup.class) @PathVariable("id") UUID id, @RequestBody final CreateAgency dto) {
        return ResponseEntity.ok(service.edit(id, dto));
    }

    @GetMapping("/toggle/{id}")
    public ResponseEntity<LightAgency> togglePublication(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.toggle(UUID.fromString(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<LightAgency> findByCode(@PathVariable("code") String code) {
        return ResponseEntity.ok(service.findByCode(code));
    }
}
