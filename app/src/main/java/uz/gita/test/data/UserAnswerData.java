package uz.gita.test.data;

public class UserAnswerData {
    private String answer;
    private boolean trueOrFalse;
    private boolean skip;

    public UserAnswerData(String answer, boolean trueOrFalse, boolean skip) {
        this.answer = answer;
        this.trueOrFalse = trueOrFalse;
        this.skip = skip;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean getTrueOrFalse() {
        return trueOrFalse;
    }

    public boolean getSkip() {
        return skip;
    }
}
