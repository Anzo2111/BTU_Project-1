import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;


public class Task3Tests {
    @Test
    public void getResponseStatus(){
        int statusCode=
                given()
                        .when()
                        .get("https://bookstore.toolsqa.com/BookStore/v1/Books")
                        .getStatusCode();
        System.out.println("The response status is "+statusCode);
        Assert.assertEquals(statusCode,200);
    }

    @Test
    public void checkLastBook(){
        given()
                .when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books")
                .then().log().all()
                .assertThat()
                .body("books[-1].isbn",equalTo("9781593277574"));

    }

    @Test
    public void checkBooksPages(){
        given()
                .when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books")
                .then().log().all()
                .assertThat()
                .body("books[0].pages",equalTo(234), "books[1].pages",equalTo(254));

    }

}
