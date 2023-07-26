package com.fuxin.web.admin;

import com.fuxin.pojo.Type;
import com.fuxin.service.TypeService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Description: TypeController
 * Author: Fuu
 * Date: 2023/7/26
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String list(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                       Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/type-add";
    }

    @PostMapping("/types")
    public String post(@Valid Type type,
                       BindingResult result,
                       RedirectAttributes attributes){
        if(result.hasErrors())
            return "admin/type-add";

        if (typeService.findByName(type.getName()) != null) {
            result.rejectValue("name","nameError","不能添加重复分类");
            return "admin/type-add";
        }

        Type type1 = typeService.saveType(type);
        if (null == type1) {
            attributes.addFlashAttribute("message","新增失败");
        }else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
//        typeService.deleteType(id);
        return "admin/type-add";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,
                         RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type,@PathVariable Long id,
                       BindingResult result,
                       RedirectAttributes attributes){
        log.info("修改保存");
        Gson gson = new Gson();
        log.info("type:" + gson.toJson(type));
        if (typeService.findByName(type.getName()) != null) {
            log.info("查到了");
            result.rejectValue("name","nameError","不能添加重复分类");
            return "admin/type-add";
        }else{
            log.info("没查到");
        }

        if(result.hasErrors())
            return "admin/type-add";

        Type type1 = typeService.updateType(id, type);
        if (null == type1) {
            attributes.addFlashAttribute("message","更新失败");
        }else {
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/types";
    }

}
