package ee.carlrobert.llm.completion;

import ee.carlrobert.llm.client.openai.completion.ErrorDetails;

public interface CompletionEventListener {

  default void onMessage(String message) {
  }

  default void onComplete(StringBuilder messageBuilder) {
  }

  default void onError(ErrorDetails error, Throwable ex) {
  }
}
