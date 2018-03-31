package com.JavaTests.controller.admin;

import com.JavaTests.entity.Role;
import com.JavaTests.entity.Topic;
import com.JavaTests.services.adminService.AdminRoleService;
import com.JavaTests.services.adminService.AdminTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin/role")
public class AdminRoleController {

    private AdminRoleService adminRoleService;

    @Autowired
    public AdminRoleController(AdminRoleService adminRoleService) {
        this.adminRoleService = adminRoleService;
    }

    //    @RequestMapping(value = "/getRole")
//    public String getRole(Model model) {
//        model.addAttribute("getRole", roleModel.getRoleAbybe());
//        return "role";
//    }

//    @RequestMapping(value = "/getRole", method = RequestMethod.GET, headers = "Accept=application/json")
//    public String getRole(Model model) {
//        model.addAttribute("getRole", adminRoleService.getRole());
//        return "admin/role";
//    }

    // получение всех Roles при нажатии на стрелочку (jsp)
    @RequestMapping(value = "/getRole", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getRole(Model model) {
        List<Role> roleList = adminRoleService.getRoles();
        //   model.addAttribute("role", new Role());
        model.addAttribute("roleList", roleList);
        return "admin/role";
    }

    // получение всех Toles при вводе в поле (jsp)
    @RequestMapping(value = "/getRoleAutoSave", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getRoleAutoSave(Model model) {
        List<Role> roleList = adminRoleService.getRoles();
        //   model.addAttribute("role", new Role());
        model.addAttribute("roleList", roleList);
        return "admin/role";
    }



//    @RequestMapping(value = {"/getRole/{roleId}"}, method = RequestMethod.GET)
//    public ModelAndView checkWord(@PathVariable("roleId") int roleId) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("role");
//        modelAndView.addObject("info", adminRoleService.getRole(roleId));
//
//        return modelAndView;
//    }














//
//    @RequestMapping(value = "/getRoleSave")
//    public String roleSave(Model model) {
//        model.addAttribute("roleSave", roleModel.getRoleSave());
//        return "roleSave";
//    }
//
//    @RequestMapping(value = "/getRoleRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public Role getRoleRest(@RequestBody Role role) {
//        return roleModel.getRoleRest(role);
//    }
//
//    @RequestMapping(value = "/getRoleSaveRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public Role getRoleSaveRest(@RequestBody Role role) {
//        return roleModel.getRoleSaveRest(role);
//    }

}
