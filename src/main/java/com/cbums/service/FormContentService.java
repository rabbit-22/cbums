package com.cbums.service;

import com.cbums.model.Form;
import com.cbums.model.FormContent;
import com.cbums.repository.FormContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FormContentService {
    private final FormContentRepository formContentRepository;
    private final FormService formService;
    private final FormQuestionService formQuestionService;

    public List<Long> createFormContent(Long formId, List<Long> formQuestionIdList) {

        List<Long> formContendId = new ArrayList<>();

        Form form = formService.findFormById(formId);
        for(Long k : formQuestionIdList) {
            //새로운 객체로 생성되나...? 아니면 기존꺼 덮어쓰기가 되나
            FormContent formContent = FormContent.builder()
                    .form(form)
                    .formQuestion(formQuestionService.findFormQuestionById(k))
                    .build();
            formContendId.add(formContentRepository.save(formContent).getFormContentId());
        }

        return formContendId;
    }

    public FormContent findFormContentById(Long formContentId) {
        return formContentRepository.findById(formContentId).orElseThrow(NullPointerException::new);
    }

    public List<FormContent> findFormContentListByFormId(Long formId){
        List<FormContent> formContentList = formContentRepository.findFormContentListByFormId(formId);
        if(formContentList.isEmpty()) throw new NoSuchElementException();
        return formContentList;
    }
}
