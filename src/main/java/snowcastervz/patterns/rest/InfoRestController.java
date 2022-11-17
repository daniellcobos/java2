package snowcastervz.patterns.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snowcastervz.patterns.model.Info;
import snowcastervz.patterns.services.InfoService;


@RestController
@RequestMapping("/api")
public class InfoRestController {

    private InfoService infoService;

    @Autowired
    public InfoRestController(InfoService theInfoService) {
        infoService = theInfoService;
    }

    // expose "/infos" and return list of infos
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/infos")
    public List<Info> findAll() {
        return infoService.findAll();
    }

    // add mapping for GET /infos/{infoId}

    @GetMapping("/infos/{infoId}")
    public Info getInfo(@PathVariable int infoId) {

        Info theInfo = infoService.findById(infoId);

        if (theInfo == null) {
            throw new RuntimeException("Info id not found - " + infoId);
        }

        return theInfo;
    }

    // add mapping for POST /infos - add new info

    @PostMapping("/infos")
    public Info addInfo(@RequestBody Info theInfo) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update



        infoService.save(theInfo);

        return theInfo;
    }

    // add mapping for PUT /infos - update existing info

    @PutMapping("/infos")
    public Info updateInfo(@RequestBody Info theInfo) {

        infoService.save(theInfo);

        return theInfo;
    }

    // add mapping for DELETE /infos/{infoId} - delete info

    @DeleteMapping("/infos/{infoId}")
    public String deleteInfo(@PathVariable int infoId) {

        Info tempInfo = infoService.findById(infoId);

        // throw exception if null

        if (tempInfo == null) {
            throw new RuntimeException("Info id not found - " + infoId);
        }

        infoService.deleteById(infoId);

        return "Deleted info id - " + infoId;
    }

}
