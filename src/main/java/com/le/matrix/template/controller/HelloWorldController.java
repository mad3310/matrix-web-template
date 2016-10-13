package com.le.matrix.template.controller;

import com.le.matrix.template.facade.UserFacade;
import com.le.matrix.template.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhanbo on 2016/10/11.
 */
@Controller
@RequestMapping("/helloWorld")
public class HelloWorldController {
    private final static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private UserFacade userFacade;

    /**
     * 使用AnnotationMethodHandlerAdapter
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public
    @ResponseBody
    User getUser(@PathVariable Integer userId) {
        User user = userFacade.selectByPrimaryKey(userId);
        return user;
    }

    /**
     * 使用ContentNegotiatingViewResolver
     *
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/api/{userId}", method = RequestMethod.GET)
    public void getUser(@PathVariable Integer userId, ModelMap model) {
        User user = userFacade.selectByPrimaryKey(userId);
        model.addAttribute("model", user);
    }

    /**
     * 使用ContentNegotiatingViewResolver
     *
     * @param userId
     * @param mav
     * @return
     */
    @RequestMapping(value = "/jsp/{userId}", method = RequestMethod.GET)
    public ModelAndView getUser2(@PathVariable Integer userId, ModelAndView mav) {
        User user = userFacade.selectByPrimaryKey(userId);
        mav.addObject("user", user);
        mav.setViewName("list");
        return mav;
    }

    /**
     * 使用AnnotationMethodHandlerAdapter
     *
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    User save(@Valid User user, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            logger.error("校验参数不合法");
            List<ObjectError> errors = bindResult.getAllErrors();
            List<String> msgs = new ArrayList<>();
            for (ObjectError error : errors) {
                msgs.add(((DefaultMessageSourceResolvable) error.getArguments()[0]).getDefaultMessage() + ":" + error.getDefaultMessage());
            }
        }
        userFacade.insert(user);
        return user;
    }

    /**
     * 使用ContentNegotiatingViewResolver
     *
     * @param userId
     * @param mav
     * @return
     */
    @RequestMapping(value = "/api", method = RequestMethod.POST)
    public void save(@Valid User user, BindingResult bindResult, ModelMap model) {
        if (bindResult.hasErrors()) {
            logger.error("校验参数不合法");
            List<ObjectError> errors = bindResult.getAllErrors();
            List<String> msgs = new ArrayList<>();
            for (ObjectError error : errors) {
                msgs.add(((DefaultMessageSourceResolvable) error.getArguments()[0]).getDefaultMessage() + ":" + error.getDefaultMessage());
            }
        }
        userFacade.insert(user);
        model.addAttribute("model", user);
    }
}
