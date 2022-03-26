package pl.test.groomer.dog;

import pl.test.groomer.client.Client;

import javax.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    @Enumerated(EnumType.STRING)
    private DogSize size;
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    public Dog() {
    }

    public Dog(String name, String breed, DogSize size, Client client) {
        this.name = name;
        this.breed = breed;
        this.size = size;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public DogSize getSize() {
        return size;
    }

    public void setSize(DogSize size) {
        this.size = size;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", size=" + size +
                '}';
    }
}

