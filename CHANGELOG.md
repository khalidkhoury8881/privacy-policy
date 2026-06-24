# Changelog

## 1.0.0 - MV3 readiness pass

- Added a Manifest V3 Chrome extension manifest with alarms, notifications, storage, tabs, a service worker, CSP, popup, options page, and content script registration.
- Removed inline JavaScript from extension HTML pages by moving behavior into external JavaScript files.
- Added a shared reminder form used by both the toolbar popup and floating Try Later button for consistent title, note, quick reminder, date, time, test notification, save, dashboard, and Ko-fi actions.
- Added unique notification IDs for every test notification click and real reminder notification.
- Added reminder scheduling through `chrome.alarms`, delivery through `chrome.notifications`, and a once-per-minute backup due-reminder check.
- Added validation to prevent reminders from being saved in the past.
- Added explicit AM/PM conversion for 12 AM, 12 PM, and afternoon/evening times.
- Added a dashboard with open source, mark tried, remind in 1 hour, tomorrow 9 AM, and delete actions.
- Added a Chrome Web Store-oriented privacy page and manual test plan.
