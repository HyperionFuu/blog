package com.fuxin.web.admin;

import com.fuxin.pojo.Tag;
import com.fuxin.service.TagService;
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
 * Description: TagController
 * Author: Fuu
 * Date: 2023/7/26
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String list(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                       Model model){
        model.addAttribute("page",tagService.listTag(pageable));
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tag-add";
    }

    @PostMapping("/tags")
    public String post(@Valid Tag tag,
                       BindingResult result,
                       RedirectAttributes attributes){
        if(result.hasErrors())
            return "admin/tag-add";

        if (tagService.findByName(tag.getName()) != null) {
            result.rejectValue("name","nameError","不能添加重复分类");
            return "admin/tag-add";
        }

        Tag tag1 = tagService.saveTag(tag);
        if (null == tag1) {
            attributes.addFlashAttribute("message","新增失败");
        }else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("tag",tagService.getTag(id));
//        tagService.deleteTag(id);
        return "admin/tag-add";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id,
                         RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/tags";
    }
    @PostMapping("/tags/{id}")
    public String editPost(@Valid Tag tag,@PathVariable Long id,
                       BindingResult result,
                       RedirectAttributes attributes){
        log.info("修改保存");
        Gson gson = new Gson();
        log.info("tag:" + gson.toJson(tag));
        if (tagService.findByName(tag.getName()) != null) {
            log.info("查到了");
            result.rejectValue("name","nameError","不能添加重复标签");
            return "admin/tag-add";
        }else{
            log.info("没查到");
        }

        if(result.hasErrors())
            return "admin/tag-add";

        Tag tag1 = tagService.updateTag(id, tag);
        if (null == tag1) {
            attributes.addFlashAttribute("message","更新失败");
        }else {
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/tags";
    }

}
