package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.PlateEntity;
import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import cn.edu.ncu.jiluan.bbs.service.PlateService;
import cn.edu.ncu.jiluan.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PlateService plateService;

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String viewPlate(Model model){
        List<PlateEntity> platelist = plateService.findAll();
        List<PostEntity> postlist = postService.findAll();
        model.addAttribute("plates",platelist);
        model.addAttribute("posts",postlist);
        return "home";
    }
    @RequestMapping("/aa/a")
    public String viewPlate1(Model model){
        List<PlateEntity> platelist = plateService.findAll();
        List<PostEntity> postlist = postService.findAll();
        model.addAttribute("plates",platelist);
        model.addAttribute("posts",postlist);
        return "home";
    }
}
