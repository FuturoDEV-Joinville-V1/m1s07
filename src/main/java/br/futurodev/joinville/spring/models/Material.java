package br.futurodev.joinville.spring.models;

import java.util.ArrayList;
import java.util.List;

public class Material {

    private static final List<Material> materials = new ArrayList<>();
    private static Long sequence = 1L;

    private Long id;
    private String name;
    private String description;

    public Material() {
        this.id = sequence++;
    }

    public Material(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<Material> getMaterials() {
        return materials;
    }

    public static Material addMaterial(Material material) {
        materials.add(material);
        return material;
    }

    public static boolean removeMaterial(Material material) {
        return materials.remove(material);
    }

}
