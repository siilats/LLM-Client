package ee.carlrobert.llm.client.openai.completion.text.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import ee.carlrobert.llm.client.openai.completion.OpenAICompletionRequest;
import ee.carlrobert.llm.client.openai.completion.text.OpenAITextCompletionModel;
import java.util.Collections;
import java.util.List;

public class OpenAITextCompletionRequest extends OpenAICompletionRequest {

  private final String prompt;
  private final String model;
  private final List<String> stop;
  @JsonProperty("best_of")
  private final int bestOf;

  private OpenAITextCompletionRequest(Builder builder) {
    super(builder);
    this.model = builder.model;
    this.prompt = builder.prompt;
    this.stop = builder.stop;
    this.bestOf = builder.bestOf;
  }

  public String getPrompt() {
    return prompt;
  }

  public String getModel() {
    return model;
  }

  public List<String> getStop() {
    return stop;
  }

  public int getBestOf() {
    return bestOf;
  }

  public static class Builder extends OpenAICompletionRequest.Builder {

    private final String prompt;
    private String model = OpenAITextCompletionModel.DAVINCI.getCode();
    private List<String> stop;
    private int bestOf = 1;

    public Builder(String prompt) {
      this.prompt = prompt;
    }

    public Builder setModel(OpenAITextCompletionModel model) {
      this.model = model.getCode();
      return this;
    }

    public Builder setModel(String model) {
      this.model = model;
      return this;
    }

    public Builder setStop(List<String> stop) {
      this.stop = Collections.unmodifiableList(stop);
      return this;
    }

    public Builder setBestOf(int bestOf) {
      this.bestOf = bestOf;
      return this;
    }

    @Override
    public OpenAITextCompletionRequest build() {
      return new OpenAITextCompletionRequest(this);
    }
  }
}
