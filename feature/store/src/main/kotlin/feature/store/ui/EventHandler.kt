package feature.store.ui

// TODO move to core
internal interface EventHandler<T> {

    fun obtainEvent(event: T)
}
