package com.example.controller;
import com.example.domain.ResponseResult;
import com.example.domain.entity.Tag;
import com.example.domain.vo.PageVo;
import com.example.domain.vo.TagVo;
import com.example.dto.AddTagDto;
import com.example.dto.EditTagDto;
import com.example.dto.TagListDto;
import com.example.service.TagService;
import com.example.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Tag)表控制层
 *
 * @author makejava
 * @since 2025-05-25 13:02:31
 */
@RestController
@RequestMapping("/content/tag")
public class TagController {

    @Autowired
    private TagService tagService;

//    //查询标签列表
//    @GetMapping("/list")
//    //ResponseResult是我们在huanf-framework工程的实体类
//    public ResponseResult list(){
//        //list是mybatisplus提供的方法
//        return ResponseResult.okResult(tagService.list());
//    }


    //查询标签列表
    @GetMapping("/list")
    //ResponseResult是我们在huanf-framework工程的实体类
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        //pageTagList是我们在huanf-framework工程写的方法
        return tagService.pageTagList(pageNum,pageSize,tagListDto);
    }
    //-------------------------------新增标签------------------------------------
    @PostMapping
    public ResponseResult add(@RequestBody AddTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto, Tag.class);
        tagService.save(tag);
        return ResponseResult.okResult();
    }
////-------------------------------删除标签------------------------------------


    @DeleteMapping("/{id}")
    //pageTagList是我们在huanf-framework工程写的方法
    public ResponseResult deleteTag(@PathVariable Long id){
        return tagService.deleteTag(id);
    }

//    @DeleteMapping("/{id}")
//    public ResponseResult delete(@PathVariable Long id){
//        tagService.removeById(id);
//        return ResponseResult.okResult();
//    }
//
//    @DeleteMapping
//    public ResponseResult remove(@RequestParam(value = "ids")String ids) {
//        if (!ids.contains(",")) {
//            tagService.removeById(ids);
//        } else {
//            String[] idArr = ids.split(",");
//            for (String id : idArr) {
//                tagService.removeById(id);
//            }
//        }
//        return ResponseResult.okResult();
//    }

    ////-------------------------------修改标签------------------------------------

//    @GetMapping("/{id}")
//    //①根据标签的id来查询标签
//    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
//        Tag tag = tagService.getById(id);
//        return ResponseResult.okResult(tag);
//    }
//
//    @PutMapping
//    //②根据标签的id来修改标签
//    public ResponseResult edit(@RequestBody EditTagDto tagDto){
//        Tag tag = BeanCopyUtils.copyBean(tagDto,Tag.class);
//        tagService.updateById(tag);
//        return ResponseResult.okResult();
//    }

    @GetMapping("/{id}")
    //①根据标签的id来查询标签
    public ResponseResult getLableById(@PathVariable Long id){
        return tagService.getLableById(id);
    }

    @PutMapping
    //②根据标签的id来修改标签
    public ResponseResult updateById(@RequestBody TagVo tagVo){
        return tagService.myUpdateById(tagVo);
    }
    //---------------------------写博文-查询文章标签的接口---------------------------

    @GetMapping("/listAllTag")
    public ResponseResult listAllTag(){
        List<TagVo> list = tagService.listAllTag();
        return ResponseResult.okResult(list);
    }
}