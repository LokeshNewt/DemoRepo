/*package com.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDetailsApplicationTests {
	
	@Test
	public void contextLoads() {
	}

	
	private MockMvc mockMvc;
	
    @Autowired
    private WebApplicationContext wac;
    
    @Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).defaultRequest(post("/")).build();
		
	}
	

    @Test 
	public void addNewProduct()
	{
	
		try {
			System.out.println("inside try============");
			if(this.mockMvc==null){
				System.out.println("====first null=====");
			}
			this.mockMvc
					.perform(post("/add/LG/mobile/10000/india")
							.contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
					.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
		}
	}
	
		
	@Test 
	public void getAllProduct()
	{
	
		try {
			System.out.println("inside try============");
			if(this.mockMvc==null){
				System.out.println("====first null=====");
			}
			this.mockMvc
					.perform(get("/search/getAllProducts")
							.contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
					.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
		}
	}
	
	@Test 
	public void getAllProductByName()
	{
	
		try {
			System.out.println("inside try============");
			if(this.mockMvc==null){
				System.out.println("====first null=====");
			}
			this.mockMvc
					.perform(get("/search/Mobile")
							.contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
					.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
		}
	}


}
*/