package br.com.btg.game.jokenpo.enums;

public enum EnumException {

    GENERIC_ERROR("ERR-0001", "JOKENPO", "GENERIC ERROR", "GENERIC ERROR", "Ocorreu um erro desconhecido"),
    INVALID_PARAM("ERR-0002", "JOKENPO", "PARAM", "INVALID", "Parâmetro inválido"),
    PLAYER_NOT_FOUND("ERR-1001", "JOKENPO", "PLAYER", "NOT FOUND", "Jogador não localizado"),
    PLAYER_ALREADY_EXISTS("ERR-1002", "JOKENPO", "PLAYER", "ALREADY EXISTS", "Jogador já cadastrado"),
    PLAYER_INVALID_NAME("ERR-1003", "JOKENPO", "PLAYER", "NAME", "Nome inválido"),
    PLAYER_SAVE_ERROR("ERR-1004", "JOKENPO", "PLAYER", "SAVE", "Erro ao salvar Jogador"),
    PLAYER_DELETE_ERROR("ERR-1005", "JOKENPO", "PLAYER", "SAVE", "Erro ao salvar Jogador"),
    PLAYER_FIND_ALL_ERROR("ERR-1006", "JOKENPO", "PLAYER", "FIND ALL", "Erro ao exibir os Jogadores"),
    PLAYER_FIND_ERROR("ERR-1007", "JOKENPO", "PLAYER", "FIND", "Erro ao exibir Jogador");

    private String code;
    private String origin;
    private String type;
    private String subType;
    private String message;

    EnumException(String code, String origin, String type, String subType, String message) {
        this.code = code;
        this.origin = origin;
        this.type = type;
        this.subType = subType;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getOrigin() {
        return origin;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /*
    public static EnumJokenpoException getEnumJokenpoExceptionByCode(String code){
        for (EnumJokenpoException elem : Arrays.asList(EnumJokenpoException.values())) {
            if (code.equals(elem.getCode())) {
                return elem;
            }
        }
        return EnumJokenpoException.GENERIC_ERROR;
    }
    */


}
