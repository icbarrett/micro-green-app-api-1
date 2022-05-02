package ingis.microgreenappapi.controllers;

import ingis.microgreenappapi.data.SeedData;
import ingis.microgreenappapi.models.Seed;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("seeds")
public class SeedController {

//    private static List<Seed> seeds = new ArrayList<>();

    @GetMapping
    public String displayAllSeeds(Model model) {
        model.addAttribute("title", "All Seeds");
        model.addAttribute("seeds", SeedData.getAll());
        return "seeds/index";
    }

    @GetMapping("create")
    public String displayCreateSeedForm(Model model) {
        model.addAttribute("title", "Create Seed");
        return "seeds/create";
    }
    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String seedName,
                                         @RequestParam Number seedingDensity,
                                         @RequestParam Boolean seedPresoak,
                                         @RequestParam Number blackoutTime,
                                         @RequestParam Number harvestTime,
                                         @RequestParam Number qty) {
        SeedData.add(new Seed(seedName, seedingDensity, seedPresoak,  blackoutTime, harvestTime, qty));
        return "redirect:";
    }


//    @GetMapping("seeds")
//    @ResponseBody
//    public String seeds() {
//        return "seeds";
//    }
//
//    @GetMapping("inventory/seeds")
//    @ResponseBody
//    public String seedsInInventory() {
//
//        return "seeds in inventory";
//    }



}
