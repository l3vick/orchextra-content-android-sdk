package com.gigigo.orchextra.core.data.dto.content;

import com.gigigo.orchextra.core.data.dto.elementcache.ApiElementCache;
import java.util.Map;

public class ApiSectionContentData {

  private ApiContentItem content;
  private Map<String, ApiElementCache> elementsCache;

  public ApiContentItem getContent() {
    return content;
  }

  public Map<String, ApiElementCache> getElementsCache() {
    return elementsCache;
  }
}
