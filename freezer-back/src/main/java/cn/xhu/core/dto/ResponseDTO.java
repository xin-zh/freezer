package cn.xhu.core.dto;

/**
 * @author:zx
 * @create time:2021/2/13 12:04
 * @desciption:基础响应DTO
 */


public class ResponseDTO {
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 提示message
     */
    private String message;
    /**
     * 存储数据
     */
    private Object data;

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseDTO createSuccessResponse() {
        return createSuccessResponse(null);
    }

    /**
     * 创建成功DTO+数据
     * @param data
     * @return
     */
    public static ResponseDTO createSuccessResponse(Object data) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccess(true);
        responseDTO.setData(data);
        return responseDTO;
    }

    /**
     * 创建失败DTO+message
     * @param message
     * @return
     */
    public static ResponseDTO createFailResponse(String message) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccess(false);
        responseDTO.setMessage(message);
        return responseDTO;
    }

}
