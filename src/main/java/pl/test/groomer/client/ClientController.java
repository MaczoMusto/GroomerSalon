package pl.test.groomer.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.test.groomer.client.dto.ClientDto;
import pl.test.groomer.dog.DogService;

@Controller
public class ClientController {

    private ClientService clientService;
    private DogService dogService;

    public ClientController(ClientService clientService, DogService dogService) {
        this.clientService = clientService;
        this.dogService = dogService;
    }

    @GetMapping("/")
    String clientList(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "results";
    }

    @GetMapping("/add")
    String addClient(){
        return "add-client";
    }

    @GetMapping("/updateClient/{id}")
    String updateClient(@PathVariable Long id, Model model){
        ClientDto clientDto = clientService.getClientById(id);
        model.addAttribute("client",clientDto);
        return "update_client";
    }

    /*@PostMapping("/client/{id}/dog/add")
    String addDogtoClient(@PathVariable Long id, Model model){

        return "add-dog";
    }

    @GetMapping("/dog/add")
    String addDog(){
        return "add-dog";
    }

    @PostMapping("/saveClient")
    String saveClient(ClientDto clientDto){
        clientService.saveClient(clientDto);
        return "redirect:/";
    }*/

}
