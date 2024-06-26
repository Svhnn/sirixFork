package io.sirix.query.json;

import io.sirix.query.stream.json.TemporalSirixJsonObjectKeyArrayStream;
import io.brackit.query.atomic.IntNumeric;
import io.brackit.query.jdm.Stream;
import io.brackit.query.jdm.json.Array;
import io.brackit.query.jdm.json.TemporalJsonItem;
import io.sirix.api.json.JsonNodeReadOnlyTrx;
import io.sirix.axis.IncludeSelf;
import io.sirix.axis.temporal.AllTimeAxis;
import io.sirix.axis.temporal.FutureAxis;
import io.sirix.axis.temporal.PastAxis;

import static java.util.Objects.requireNonNull;

public final class JsonObjectKeyDBArray extends AbstractJsonDBArray<JsonObjectKeyDBArray>
    implements TemporalJsonItem<JsonObjectKeyDBArray> {

  /**
   * Sirix read-only transaction.
   */
  private final JsonNodeReadOnlyTrx rtx;

  /**
   * Collection this node is part of.
   */
  private final JsonDBCollection collection;

  /**
   * Constructor.
   *
   * @param rtx        {@link JsonNodeReadOnlyTrx} for providing reading access to the underlying node
   * @param collection {@link JsonDBCollection} reference
   */
  public JsonObjectKeyDBArray(final JsonNodeReadOnlyTrx rtx, final JsonDBCollection collection) {
    super(rtx, collection, new JsonItemFactory());
    this.collection = requireNonNull(collection);
    this.rtx = requireNonNull(rtx);
    assert this.rtx.isObject();
  }

  @Override
  public Stream<JsonObjectKeyDBArray> getEarlier(final boolean includeSelf) {
    moveRtx();
    final IncludeSelf include = includeSelf
        ? IncludeSelf.YES
        : IncludeSelf.NO;
    return new TemporalSirixJsonObjectKeyArrayStream(new PastAxis<>(rtx.getResourceSession(), rtx, include), collection);
  }

  @Override
  public Stream<JsonObjectKeyDBArray> getFuture(final boolean includeSelf) {
    moveRtx();
    final IncludeSelf include = includeSelf
        ? IncludeSelf.YES
        : IncludeSelf.NO;
    return new TemporalSirixJsonObjectKeyArrayStream(new FutureAxis<>(rtx.getResourceSession(), rtx, include), collection);
  }

  @Override
  public Stream<JsonObjectKeyDBArray> getAllTimes() {
    moveRtx();
    return new TemporalSirixJsonObjectKeyArrayStream(new AllTimeAxis<>(rtx.getResourceSession(), rtx), collection);
  }

  @Override
  public Array range(IntNumeric from, IntNumeric to) {
    moveRtx();

    return new JsonDBArraySlice(rtx, collection, from.intValue(), to.intValue());
  }

  @Override
  protected JsonObjectKeyDBArray createInstance(JsonNodeReadOnlyTrx rtx, JsonDBCollection collection) {
    return new JsonObjectKeyDBArray(rtx, collection);
  }
}
