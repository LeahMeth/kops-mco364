package kops.mco364.todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ToDoServiceTest {

	
	@Test
	public void testListToDos() throws IOException{
		
		Retrofit retrofit = new Retrofit.Builder()
	    .baseUrl("http://jsonplaceholder.typicode.com/")
	    .addConverterFactory(GsonConverterFactory.create())
	    .build();

		ToDoService service = retrofit.create(ToDoService.class);
		
		Call<List<ToDo>> call = service.listToDos();
		Response<List<ToDo>>response = call.execute();
		
		List<ToDo> list = response.body();
		Assert.assertEquals(200, list.size());
		
	}
	
	
}

