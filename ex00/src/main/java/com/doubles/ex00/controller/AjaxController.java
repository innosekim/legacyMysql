package com.doubles.ex00.controller;

import com.doubles.ex00.domain.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ajax/test")
public class AjaxController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello W";
    }

    @RequestMapping("/sendVO")
    public SampleVO sencVO() {
        SampleVO sample = new SampleVO();
        sample.setSampleNo(1);
        sample.setFirstName("멍");
        sample.setLastName("냥");

        return sample;
    }

    //# 컬렉션 타입(List)의 객체를 리턴할 경우 메서드 작성법
    @RequestMapping("/sendList")
    public List<SampleVO> sendList() {

        List<SampleVO> samples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SampleVO sample = new SampleVO();
            sample.setSampleNo(i);
            sample.setFirstName("멍");
            sample.setLastName("냥" + i);
            samples.add(sample);
        }

        return samples;
    }

    // # 컬렉션 타입(Map)의 객체를 리턴할 경우 메서드 작성법
    @RequestMapping("/sendMap")
    public Map<Integer, SampleVO> sendMap() {

        Map<Integer, SampleVO> sampleMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            SampleVO sample = new SampleVO();
            sample.setFirstName("멍");
            sample.setLastName("냥" + i);
            sample.setSampleNo(i);
            sampleMap.put(i, sample);
        }

        return sampleMap;
    }
    @RequestMapping("/sendErrorAuth")
    public ResponseEntity<Void> sendListAuth() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping("/sendErrorNot")
    public ResponseEntity<List<SampleVO>> sendListNot() {

        List<SampleVO> samples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SampleVO sample = new SampleVO();
            sample.setSampleNo(i);
            sample.setFirstName("멍멍");
            sample.setLastName("냥" + i);
            samples.add(sample);
        }
        return new ResponseEntity<>(samples, HttpStatus.NOT_FOUND);
    }

}
