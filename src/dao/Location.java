package dao;

import java.util.List;

public class Location {
    private String name;
    private String description;
    private Items items;
    private List<NPC> npcs;
    private List<Character> characters;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }

    public String getName() {
        return name;
    }

    public Items getItems() {
        return items;
    }

    public List<NPC> getNPCs() {
        return npcs;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public void setNPCs(List<NPC> npcs) {
        this.npcs = npcs;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
