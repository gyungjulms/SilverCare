package kr.onthelive.silver.dtos.base;

import java.util.Objects;

public class BaseResponseDto {
    private boolean result;
    private String message;

    public BaseResponseDto() {
        this.result = false;
        this.message = null;
    }

    public BaseResponseDto(boolean result, String message ) {
        this.message = message;
        this.result = result;
    }

//    public BaseResponseDto(String message) {
//        this.result = false;
//        this.message = message;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) { this.message = message; }

    public boolean getResult() {  return result; }
    public void setResult(boolean result) { this.result = result; }

    public void setResultTrue() { this.setResult(Boolean.TRUE); }
    public void setResultFalse() {
        this.setResult(Boolean.FALSE);
    }

    public void setSuccess() { this.setResult(Boolean.TRUE); this.setMessage("success"); }
    public void setFailure(String message) { this.setResult(Boolean.FALSE); this.setMessage(message); }

    public static BaseResponseDto getSuccess(){
        return new BaseResponseDto(true, "success");
    }

    public static BaseResponseDto getFailure(String message){
        return new BaseResponseDto(false, message);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseResponseDto entity = (BaseResponseDto) o;
        return Objects.equals(this.message, entity.message) &&
                Objects.equals(this.result, entity.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, message);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "result = " + result + ", " +
                "message = " + message + ")";
    }
}

