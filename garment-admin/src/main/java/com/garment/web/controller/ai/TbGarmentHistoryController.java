package com.garment.web.controller.ai;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.validation.Valid;

import com.garment.web.dto.*;
import com.garment.web.service.ITbMenuService;
import com.garment.web.util.ProjectUtils;
import com.garment.web.vo.HistoryVO;
import com.garment.web.vo.MenuVO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.garment.common.core.controller.BaseController;
import com.garment.common.core.domain.AjaxResult;
import com.garment.web.domain.TbGarmentHistory;
import com.garment.web.service.ITbGarmentHistoryService;
import com.garment.common.core.page.TableDataInfo;

/**
 * historyController
 *
 * @author lee
 * @date 2023-10-24
 */
@RestController
@RequestMapping("/web/history")
public class TbGarmentHistoryController extends BaseController
{
    @Autowired
    private ITbGarmentHistoryService tbGarmentHistoryService;

    @Autowired
    private ITbMenuService tbMenuService;

    @Autowired
    private RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法


    /**
     * 获取历史记录列表
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/24
     *@param
     *@return com.garment.common.core.page.TableDataInfo
     *@throws
     */
    @GetMapping("/list")
    public TableDataInfo list( )
    {
        startPage();
        List<HistoryVO> list = tbGarmentHistoryService.selectTbGarmentHistoryList();
        return getDataTable(list);
    }

    /**
     * 生成图片
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/31
     *@param text
     *@return java.lang.String
     *@throws
     */
    @GetMapping("/imagine")
    public String image(String text) throws IOException {
        return ProjectUtils.imagineImage(text);
    }

    /**
     * 获取图片详情
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/31
     *@param messageId
     *@return java.lang.String
     *@throws
     */
    @GetMapping("/getImagineByMessageId")
    public String getImagineByMessageId(String messageId) throws IOException {
        return ProjectUtils.getImagineDetail(messageId);
    }



    /**
     * 获取详情
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/25
     *@param id
     *@return com.garment.web.domain.TbGarmentHistory
     *@throws
     */
    @GetMapping("/getById")
    public TbGarmentHistory getById(Long id )
    {
        return tbGarmentHistoryService.selectTbGarmentHistoryById(id);
    }

    /**
     * 添加历史记录
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/25
     *@param addHistoryDTO
     *@return com.garment.common.core.domain.AjaxResult
     *@throws
     */
    @PostMapping("/addHistory")
    public AjaxResult addHistory(@Valid @RequestBody AddHistoryDTO addHistoryDTO   )
    {
        return tbGarmentHistoryService.addHistory(addHistoryDTO);
    }

    @GetMapping("/testDownLoad")
    public void testDownLoad() throws IOException {
    }


    /**
     * 获取ai左侧菜单栏目显示
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/8
     *@param
     *@return java.util.List<com.garment.web.vo.MenuVO>
     *@throws
     */
    @GetMapping("/getMenuList")
    public List<MenuVO> getMenuList() throws IOException {
        return  tbMenuService.getMenuList();
    }

    /**
     *
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/9
     *@param
     *@return void
     *@throws
     */
    @PostMapping("/text2img")
    public AjaxResult testTet2Image(@RequestBody Txt2ImgDTO txt2ImgDTO) throws IOException {
         return tbGarmentHistoryService.txt2Img(txt2ImgDTO);
    }

    /**
     * 图生图
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/10
     *@param imageDTO
     *@return com.garment.common.core.domain.AjaxResult
     *@throws
     */
    @PostMapping("/img2img")
    public AjaxResult img2img(@RequestBody Img2ImgDTO imageDTO) throws IOException {
        return tbGarmentHistoryService.img2Img(imageDTO);
    }



    /***
     * mq测试发送消息
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/20
     *@param
     *@return java.lang.String
     *@throws
     */
    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
//        stopListening();
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        System.out.println("发送消息");
        return "ok";
    }

//    @Autowired
//    private SimpleMessageListenerContainer messageListenerContainer;
//
//    public void startListening() {
//        messageListenerContainer.getListenerId();
//        messageListenerContainer.start();
//    }
//
//    public void stopListening() {
//        messageListenerContainer.stop();
//    }



    @GetMapping("/newQuee")
    public String newQuee() {

        new Queue("Test111Queue",true);
        return "11";
    }




}
