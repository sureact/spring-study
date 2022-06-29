import lombok.Getter;
import lombok.Setter;

@Getter
public class Rectangle {
    private int width;
    private int height;

    public void setWidth(int width) {
        if(width<0){
            throw new IllegalArgumentException("너비 값은 음수가 될 수 없습니다.");
        }
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea(){
        int result = this.height * this.width;
        if(result <0){
            throw new IllegalArgumentException("넓이 값은 음수가 될 수 없습니다.");
        }else{
            return result;
        }
    }
}

