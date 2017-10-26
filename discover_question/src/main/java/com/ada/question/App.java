package com.ada.question;

import com.ada.imake.ChainMake;
import com.ada.imake.template.hibernate.TemplateHibernateDir;
import com.ada.imake.templates.adminlte.TemplateAdminLTE;
import com.ada.question.data.entity.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ChainMake make = new ChainMake(TemplateAdminLTE.class, TemplateHibernateDir.class);
        make.setAction("com.ada.question.controller.admin");

        File view = new File("E:\\mvnspace\\usite\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
        make.setView(view);

        List<Class<?>> cs = new ArrayList<Class<?>>();
        cs.add(Question.class);
        cs.add(QuestionAnswer.class);
        cs.add(QuestionAnswerVote.class);
        cs.add(QuestionCatalog.class);
        cs.add(QuestionFavorite.class);
        cs.add(QuestionPoints.class);
        cs.add(QuestionTag.class);
        cs.add(QuestionVote.class);
        cs.add(QuestionWord.class);


        make.setDao(true);
        make.setService(true);
        make.setView(false);
        make.setAction(true);
        make.makes(cs);
        System.out.println("ok");
    }
}
