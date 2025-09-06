package com.bharath.moduleone;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/engineer/")
public class EngineerController {

    private final EngineerService engineerService;

    public EngineerController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @GetMapping()
    public List<Engineer> getEngineer(){
        return engineerService.getAllEngineers();
//        return List.of(
//                new Engineer(1,"Johnny",List.of("Java, Springboot, Bootstrap, React")),
//                new Engineer(2,"Max",List.of("Java, Python, C++, Dot Net"))
//                );
    }


    @GetMapping("{id}")
    public Engineer getEngineerById(@PathVariable Integer id) {
        return engineerService.getAllEngineerById(id);
    }

    @PostMapping()
    public void addEngineer(@RequestBody  Engineer engineer){
        engineerService.insertEngineer(engineer);
    }
}
