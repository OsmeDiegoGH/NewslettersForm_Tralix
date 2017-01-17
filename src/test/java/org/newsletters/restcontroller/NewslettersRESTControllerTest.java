package org.newsletters.restcontroller;

import java.lang.reflect.InvocationTargetException;
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
import org.mockito.MockitoAnnotations;
import org.newsletters.daos.OracleDAO;
import org.newsletters.entities.Suscriptor;
import org.newsletters.repositories.SuscriptorRepository;
import org.newsletters.restcontroller.NewslettersRESTController.SaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(JUnitParamsRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
    "classpath*:/WEB-INF/beans.xml" 
})
public class NewslettersRESTControllerTest {
    
    private NewslettersRESTController contoller;
    private final TestContextManager testContextManager = new TestContextManager(NewslettersRESTControllerTest.class);
    private final FakeBuilder fakeBuilder = new FakeBuilder();
    
    @Autowired 
    MockHttpServletRequest request;
    @Autowired
    protected WebApplicationContext webApplicationContext;
    @Autowired
    protected MockHttpSession mockHttpSession;
    
    @Mock
    private OracleDAO<Suscriptor> mockDAO;
    
    @Before
    public void init() throws Exception{
        MockitoAnnotations.initMocks(this);
        contoller = new NewslettersRESTController(new SuscriptorRepository(mockDAO));
        //Manual initialization of context manager since JUnitParamsRunner is used
        this.testContextManager.prepareTestInstance(this);
    }    
    
    @Test
    public void itShouldReturnHTTPOk_save() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FakeBuilderProcessor.InvalidTypeException, FakeBuilderProcessor.ConstructorNotFoundException {
        //Arrange
        SaveDTO dto = fakeBuilder.createNew(SaveDTO.class).build();

        //Act
        ResponseEntity<?> response = contoller.save(dto);

        //Assert       
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    public void itShouldBubbleErrorFromDAO_save() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FakeBuilderProcessor.InvalidTypeException, FakeBuilderProcessor.ConstructorNotFoundException {
        //Arrange
        SaveDTO dto = fakeBuilder.createNew(SaveDTO.class).build();
        doThrow(new HibernateException("")).when(mockDAO).insert(Matchers.any(Suscriptor.class));
        
        //Act
        ResponseEntity<?> response = contoller.save(dto);

        //Assert       
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
