package br.futurodev.joinville.spring.services;

import br.futurodev.joinville.spring.dtos.MaterialRequestDto;
import br.futurodev.joinville.spring.dtos.MaterialResponseDto;
import br.futurodev.joinville.spring.models.Material;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialService {

    public List<MaterialResponseDto> findAll() {
        List<MaterialResponseDto> response = new ArrayList<>();

        for (Material material : Material.getMaterials()) {
            response.add(new MaterialResponseDto(
                    material.getId(),
                    material.getName(),
                    material.getDescription())
            );
        }

        return response;

/*      Faz um mapeamento de Material para MaterialResponseDto */
//        return Material.getMaterials().stream()
//                .map(
//                        material -> new MaterialResponseDto(
//                                    material.getId(),
//                                    material.getName(),
//                                    material.getDescription()
//                        ))
//                .collect(Collectors.toList());
    }

    public MaterialResponseDto save(MaterialRequestDto dto) {
        Material material = new Material();
        material.setName(dto.name());
        material.setDescription(dto.description());

        material = Material.addMaterial(material);

        return new MaterialResponseDto(material.getId(), material.getName(), material.getDescription());
    }

    public MaterialResponseDto findById(Long id) {
        Material material = this.findMaterialById(id);
        if (material != null) {
            return new MaterialResponseDto(
                    material.getId(),
                    material.getName(),
                    material.getDescription()
            );
        }
        return null;
    }

    public MaterialResponseDto update(Long id, MaterialRequestDto dto) {
        Material material = this.findMaterialById(id);
        if (material != null) {
            material.setName(dto.name());
            material.setDescription(dto.description());

            return new MaterialResponseDto(
                    material.getId(),
                    material.getName(),
                    material.getDescription()
            );
        }

        return null;
    }

    private Material findMaterialById(Long id) {
        for (Material material : Material.getMaterials()) {
            if (material.getId().equals(id)) {
                return material;
            }
        }
        return null;
    }
}
