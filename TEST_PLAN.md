# ActLater Manual Test Plan

1. Load the extension unpacked in Chrome from this project folder.
2. Open the toolbar popup and confirm it shows title, note, quick reminder buttons, date, hour, minute, AM/PM, Test notification, Save & remind me, Dashboard, and Ko-fi.
3. Click **Test notification** three times and confirm three separate Chrome notifications appear.
4. Save a reminder 5 minutes in the future from the popup and confirm the dashboard lists the saved title, note, URL, and formatted reminder time.
5. Try saving a reminder in the past and confirm the form blocks it with an error.
6. On a normal webpage, click the floating **Try Later** button and confirm it shows the same save fields and actions as the popup.
7. Save a reminder from the floating form and confirm it appears in the dashboard.
8. Test AM/PM conversion by saving future reminders using 12 AM, 12 PM, 2 PM, and 9 PM; confirm each dashboard time matches 00, 12, 14, and 21 hour behavior respectively.
9. In the dashboard, click **Open source** and confirm the original URL opens in a new tab.
10. Click **Mark tried** and confirm the item is marked tried.
11. Click **Remind in 1 hour** and confirm the item is active again and scheduled one hour ahead.
12. Click **Tomorrow 9 AM** and confirm the reminder time changes to tomorrow at 9:00 AM.
13. Click **Delete** and confirm the item is removed.
14. Wait for a due reminder and confirm Chrome shows a notification; also confirm overdue reminders are caught by the once-per-minute backup check.
15. Click every Ko-fi link and confirm it opens https://ko-fi.com/khalidkhoury.
