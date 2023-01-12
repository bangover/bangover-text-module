package cloud.bangover.locale;

import java.util.Locale;
import java.util.Optional;

import cloud.bangover.StubbingQueue;

public class StubLocaleExtractor implements PlatformLocaleProvider.LocaleExtractor {
  private final StubbingQueue<Optional<Locale>> stubbingQueue;

  public StubLocaleExtractor(Optional<Locale> defaultLocale) {
    this.stubbingQueue = new StubbingQueue<>(defaultLocale);
  }

  public StubbingQueue.StubbingQueueConfigurer<Optional<Locale>> configure() {
    return stubbingQueue.configure();
  }

  @Override
  public Optional<Locale> extractLocale() {
    return stubbingQueue.peek();
  }
}
