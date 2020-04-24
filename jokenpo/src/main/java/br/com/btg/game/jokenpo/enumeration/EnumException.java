package br.com.btg.game.jokenpo.enumeration;

public enum EnumException {

    GENERIC_ERROR("ERR-0001", "JOKENPO", "GENERIC ERROR", "GENERIC ERROR", "Ocorreu um erro desconhecido"),
    INVALID_PARAM("ERR-0002", "JOKENPO", "PARAM", "INVALID", "Parâmetro inválido"),

    // PLAYER
    PLAYER_NOT_FOUND("ERR-1001", "JOKENPO", "PLAYER", "NOT FOUND", "Jogador não localizado"),
    PLAYER_ALREADY_EXISTS("ERR-1002", "JOKENPO", "PLAYER", "ALREADY EXISTS", "Jogador já cadastrado"),
    PLAYER_INVALID_NAME("ERR-1003", "JOKENPO", "PLAYER", "NAME", "Nome inválido"),
    PLAYER_SAVE_ERROR("ERR-1004", "JOKENPO", "PLAYER", "SAVE", "Erro ao salvar Jogador"),
    PLAYER_DELETE_ERROR("ERR-1005", "JOKENPO", "PLAYER", "SAVE", "Erro ao excluir Jogador"),
    PLAYER_FIND_ALL_ERROR("ERR-1006", "JOKENPO", "PLAYER", "FIND ALL", "Erro ao localizar os Jogadores"),

    // MOVEMENT
    MOVEMENT_NOT_FOUND("ERR-2001", "JOKENPO", "MOVEMENT", "NOT FOUND", "Jogada não localizada"),
    MOVEMENT_ALREADY_EXISTS("ERR-2002", "JOKENPO", "MOVEMENT", "ALREADY EXISTS", "Este jogador já jogou anteriormente"),
    MOVEMENT_INVALID("ERR-2003", "JOKENPO", "MOVEMENT", "INVALID", "Jogada inválida"),
    MOVEMENT_SAVE_ERROR("ERR-2004", "JOKENPO", "MOVEMENT", "SAVE", "Erro ao salvar Jogada"),
    MOVEMENT_DELETE_ERROR("ERR-2005", "JOKENPO", "MOVEMENT", "SAVE", "Erro ao excluir Jogada"),
    MOVEMENT_FIND_ALL_ERROR("ERR-2006", "JOKENPO", "MOVEMENT", "FIND ALL", "Erro ao localizar as Jogadas");

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
