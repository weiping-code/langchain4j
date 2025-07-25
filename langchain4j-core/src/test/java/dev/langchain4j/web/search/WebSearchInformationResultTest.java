package dev.langchain4j.web.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class WebSearchInformationResultTest {

    @Test
    void should_return_webSearchInformationResult_with_default_values() {
        WebSearchInformationResult webSearchInformationResult = new WebSearchInformationResult(1L);

        assertThat(webSearchInformationResult.totalResults()).isEqualTo(1L);
        assertThat(webSearchInformationResult.pageNumber()).isNull();
        assertThat(webSearchInformationResult.metadata()).isEmpty();

        assertThat(webSearchInformationResult)
                .hasToString("WebSearchInformationResult{totalResults=1, pageNumber=null, metadata={}}");
    }

    @Test
    void should_return_webSearchInformationResult_with_informationResult() {
        WebSearchInformationResult webSearchInformationResult = WebSearchInformationResult.from(1L);

        assertThat(webSearchInformationResult.totalResults()).isEqualTo(1L);
        assertThat(webSearchInformationResult.pageNumber()).isNull();
        assertThat(webSearchInformationResult.metadata()).isEmpty();

        assertThat(webSearchInformationResult)
                .hasToString("WebSearchInformationResult{totalResults=1, pageNumber=null, metadata={}}");
    }

    @Test
    void equals_and_hash() {
        WebSearchInformationResult wsi1 = WebSearchInformationResult.from(1L);
        WebSearchInformationResult wsi2 = WebSearchInformationResult.from(1L);

        assertThat(wsi1)
                .isEqualTo(wsi1)
                .isNotEqualTo(null)
                .isNotEqualTo(new Object())
                .isEqualTo(wsi2)
                .hasSameHashCodeAs(wsi2);

        assertThat(WebSearchInformationResult.from(2L)).isNotEqualTo(wsi1);
    }

    @Test
    void should_throw_illegalArgumentException() {
        IllegalArgumentException exception = assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> WebSearchInformationResult.from(null))
                .actual();
        assertThat(exception.getMessage()).isEqualTo("totalResults cannot be null");
    }
}
