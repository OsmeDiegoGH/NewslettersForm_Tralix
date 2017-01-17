package org.newsletters.webcontrollers;

import org.newsletters.restcontroller.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import junitparams.JUnitParamsRunner;
import org.fakebuilder.api.FakeBuilder;
import org.fakebuilder.structures.FakeBuilderProcessor;
import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.newsletters.daos.OracleDAO;
import org.newsletters.entities.Industry;
import org.newsletters.entities.State;
import org.newsletters.entities.Suscriptor;
import org.newsletters.repositories.IndustryRepository;
import org.newsletters.repositories.StateRepository;
import org.newsletters.repositories.SuscriptorRepository;
import org.newsletters.restcontroller.NewslettersRESTController.SaveDTO;
import org.newsletters.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(JUnitParamsRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
    "classpath*:/WEB-INF/beans.xml" 
})
public class NewslettersServletTest {
    
    private NewslettersServlet servlet;
    private final TestContextManager testContextManager = new TestContextManager(NewslettersServletTest.class);
    private final FakeBuilder fakeBuilder = new FakeBuilder();
    
    @Autowired 
    MockHttpServletRequest request;
    @Autowired
    protected WebApplicationContext webApplicationContext;
    @Autowired
    protected MockHttpSession mockHttpSession;
    
    @Mock
    private OracleDAO<State> mockStateDAO;
    @Mock
    private OracleDAO<Industry> mockIndustryDAO;
    
    @Before
    public void init() throws Exception{
        MockitoAnnotations.initMocks(this);
        servlet = new NewslettersServlet(
                new StateRepository(mockStateDAO),
                new IndustryRepository(mockIndustryDAO)
        );
        //Manual initialization of context manager since JUnitParamsRunner is used
        this.testContextManager.prepareTestInstance(this);
    }    
    
    @Test
    public void itShouldReturnValidModelAndView_viewForm() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FakeBuilderProcessor.InvalidTypeException, FakeBuilderProcessor.ConstructorNotFoundException, Exception {
        //Arrange
        List<State> expectedStates = fakeBuilder.createList(State.class).ofSize(7).all().build();
        String expectedStatesStr = JSONUtils.INSTANCE.ObjectToJSON(expectedStates);
        when(mockStateDAO.get()).thenReturn(expectedStates);
        
        List<Industry> expectedIndustries = fakeBuilder.createList(Industry.class).ofSize(7).all().build();
        String expectedIndustriesStr = JSONUtils.INSTANCE.ObjectToJSON(expectedIndustries);
        when(mockIndustryDAO.get()).thenReturn(expectedIndustries);

        //Act
        ModelAndView responseView = servlet.viewForm();

        //Assert       
        Map<String, Object> model = responseView.getModel();
        Assert.assertTrue(model.containsKey("states"));
        Assert.assertTrue(model.containsKey("industries"));
        Assert.assertEquals(expectedStatesStr, model.get("states"));
        Assert.assertEquals(expectedIndustriesStr, model.get("industries"));
    }
    
    @Test
    public void itShouldReturnEmptyStateList_OnError_viewForm() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FakeBuilderProcessor.InvalidTypeException, FakeBuilderProcessor.ConstructorNotFoundException, Exception {
        //Arrange
        when(mockStateDAO.get()).thenThrow(new HibernateException(""));

        //Act
        ModelAndView responseView = servlet.viewForm();

        //Assert       
        Map<String, Object> model = responseView.getModel();
        Assert.assertTrue(model.containsKey("states"));
        Assert.assertEquals("[]", model.get("states"));
    }
    
    @Test
    public void itShouldReturnEmptyIndustryList_OnError_viewForm() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FakeBuilderProcessor.InvalidTypeException, FakeBuilderProcessor.ConstructorNotFoundException, Exception {
        //Arrange
        when(mockIndustryDAO.get()).thenThrow(new HibernateException(""));

        //Act
        ModelAndView responseView = servlet.viewForm();

        //Assert       
        Map<String, Object> model = responseView.getModel();
        Assert.assertTrue(model.containsKey("industries"));
        Assert.assertEquals("[]", model.get("industries"));
    }
    
}
