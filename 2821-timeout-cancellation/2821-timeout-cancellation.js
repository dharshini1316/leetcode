/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {
    // Start a timer to execute fn with args after t ms
    const timeoutId = setTimeout(() => {
        fn(...args);
    }, t);

    // Return a cancel function to stop the timeout
    return function cancelFn() {
        clearTimeout(timeoutId);
    };
};